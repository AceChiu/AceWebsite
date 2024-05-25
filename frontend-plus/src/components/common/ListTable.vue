<template>
  <div class="list-table">
    <el-input
      v-if="showSearchBar"
      class="list-table__search"
      v-model="searchInput"
      placeholder="Search"
      @input="props.frontendSearch ? searchFilter($event) : emit('onSearch', $event)"
    />
    <el-table
      v-loading="props.isLoading"
      class="list-table__table"
      :data="
        props.frontendSearch && searchInput.trim().length > 0
          ? searchData.slice(
              (page.currentPage - 1) * page.pageSize,
              page.currentPage * page.pageSize
            )
          : props.tableData.slice(
              (page.currentPage - 1) * page.pageSize,
              page.currentPage * page.pageSize
            )
      "
      :stripe="props.stripe"
      @row-click="$emit('row-click', $event)"
      @sort-change="sortChanged"
    >
      <el-table-column
        v-for="col in props.tableCol"
        :key="`col-${col.colKey}`"
        v-bind="col"
        :label="col.name"
        :className="`list-table__col--${col.colKey}`"
        :prop="col.colKey"
      >
        <template v-slot="scope">
          <slot v-if="$slots[col.colKey] && !col.type" :name="col.colKey" :scope="scope" />
          <template v-else-if="col.type === 'switch'">
            <el-switch
              v-model="scope.row[col.colKey]"
              @change="switchChange(scope.row, scope.$index)"
            />
          </template>
          <template v-else-if="col.type === 'link'">
            <div @click="$emit('link-click', scope.row)" v-html="scope.row[col.colKey]" />
          </template>
          <template v-else>
            <a
              v-if="col.externalLink"
              :href="col.externalLink(scope.row[col.colKey], scope.row)"
              target="_blank"
              v-html="scope.row[col.colKey]"
            />
            <span v-else-if="scope.row[col.colKey]" v-html="scope.row[col.colKey]" />
          </template>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      v-if="props.showPagination"
      layout="prev, pager, next, jumper"
      :total="
        props.frontendSearch && searchInput.trim().length > 0
          ? searchData.length
          : props.tableData.length
      "
      :page-size="page.pageSize"
      :pager-count="5"
      :current-page="page.currentPage"
      hide-on-single-page
      @current-change="handleCurrentChange"
    />
  </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import debounce from 'lodash/debounce'
import scrollToTop from '~/util/composables/basic'

const searchInput = ref('')
const searchData = ref<any>([])
const page = reactive<{ currentPage: number; pageSize: number }>({
  currentPage: 1,
  pageSize: 10
})
type TC = {
  colKey: any
  name: string
  type?: string
  width?: number
  externalLink?: any
}
const props = withDefaults(
  defineProps<{
    isLoading?: boolean
    tableCol: Array<TC>
    tableData: Array<Object>
    stripe?: boolean
    showPagination?: boolean
    frontendSearch?: boolean
    showSearchBar?: boolean
  }>(),
  {
    isLoading: false,
    stripe: true,
    showPagination: true,
    frontendSearch: true,
    showSearchBar: true
  }
)
const emit = defineEmits(['switchChange', 'onSearch', 'sortChange', 'link-click', 'row-click'])

const searchFilter = debounce((keyWord: string) => {
  searchData.value = []
  page.currentPage = 1
  props.tableData.forEach((e) => {
    Object.values(e).forEach((val) => {
      if (val.toLowerCase().match(keyWord.toLowerCase()) && searchData.value.indexOf(e) === -1) {
        searchData.value.push(e)
      }
    })
  })
}, 300)
function switchChange(e: any, i: any) {
  emit('switchChange', e, i)
}
function handleCurrentChange(val: number) {
  page.currentPage = val
  scrollToTop()
}
function sortChanged(e: Object) {
  emit('sortChange', e)
}
</script>

<style lang="scss" scoped>
.list-table {
  display: flex;
  flex-direction: column;
  &__search {
    width: 300px;
    align-self: flex-end;
    margin-bottom: 20px;
  }
  &__table {
    width: 100%;
    td {
      .cell {
        display: flex;
        align-items: center;
      }
      &.is-center {
        .cell {
          justify-content: center;
        }
      }
      &.is-right {
        .cell {
          justify-content: flex-end;
        }
      }
    }
    &__icon {
      font-size: 20px;
    }
    a {
      text-decoration: none;
    }
    .el-button {
      position: relative;
      &:not(.is-disabled) {
        z-index: 1;
      }
      + .el-button {
        margin-left: 7px;
      }
    }
    .el-table {
      &__header,
      &__body {
        width: 100% !important;
      }
    }
  }
}

.el-pagination {
  overflow: auto;
  margin-top: 30px;
  .el-pager {
    li {
      width: 48px;
      height: 48px;
    }
  }
  @media (max-width: 767.98px) {
    margin-top: 16px;
    text-align: center;
    .el-pager {
      li {
        display: inline-flex;
        justify-content: center;
        align-items: center;
        color: #222;
        width: 40px;
        height: 40px;
        border-radius: 50%;
        padding: 0;
        &.active {
          background-color: #222;
          color: #fff;
        }
        + li {
          margin-left: 16px;
        }
      }
    }
  }
}
</style>
