<template>
  <PageHeader title="Info Page">
    <el-button type="primary" @click="onSubmit"> Save </el-button>
  </PageHeader>
  <el-card class="box-card">
    <el-row type="flex">
      <el-col :span="24">
        <el-form :model="form" label-width="120px">
          <el-form-item label="Activity name">
            <el-input v-model="form.name" />
          </el-form-item>
          <el-form-item label="Activity zone">
            <el-select v-model="form.region" placeholder="please select your zone">
              <el-option label="Zone one" value="shanghai" />
              <el-option label="Zone two" value="beijing" />
            </el-select>
          </el-form-item>
          <el-form-item label="Activity time">
            <el-col :span="11">
              <el-date-picker
                v-model="form.date1"
                type="date"
                placeholder="Pick a date"
                style="width: 100%"
              />
            </el-col>
            <el-col :span="2" class="text-center">
              <span class="text-gray-500">-</span>
            </el-col>
            <el-col :span="11">
              <el-time-picker v-model="form.date2" placeholder="Pick a time" style="width: 100%" />
            </el-col>
          </el-form-item>
          <el-form-item label="Instant delivery">
            <el-switch v-model="form.delivery" />
          </el-form-item>
          <el-form-item label="Activity type">
            <el-checkbox-group v-model="form.type">
              <el-checkbox label="Online activities" name="type" />
              <el-checkbox label="Promotion activities" name="type" />
              <el-checkbox label="Offline activities" name="type" />
              <el-checkbox label="Simple brand exposure" name="type" />
            </el-checkbox-group>
          </el-form-item>
          <el-form-item label="Resources">
            <el-radio-group v-model="form.resource">
              <el-radio label="Sponsor" />
              <el-radio label="Venue" />
            </el-radio-group>
          </el-form-item>
          <el-form-item label="Activity form">
            <el-input v-model="form.desc" type="textarea" />
          </el-form-item>
          <DragToUpload :maxFileSize="5" tip="files with a size less than 5MB"></DragToUpload>
        </el-form>
      </el-col>
    </el-row>
  </el-card>
  <el-card>
    <ListTable :isLoading="false" :tableCol="tableCol" :tableData="tableData" :stripe="false" />
  </el-card>
</template>

<script lang="ts" setup>
import { ref, reactive, defineComponent } from 'vue'
import DragToUpload from '~/components/common/DragToUpload.vue'
import PageHeader from '~/components/common/PageHeader.vue'
import ListTable from '~/components/common/ListTable.vue'

// do not use same name with ref
const form = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: ''
})
const tableCol = ref([
  { colKey: 'date', name: '日期' },
  {
    colKey: 'name',
    name: '姓名',
    externalLink: (_col: any, row: { externalLink: string }) => row.externalLink
  },
  { colKey: 'address', name: '地址' },
  { colKey: 'switcher', name: 'Switcher', type: 'switch' }
])
const tableData = ref([
  {
    date: '2023-05-01',
    name: 'E',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW'
  },
  {
    date: '2023-05-02',
    name: 'M',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW'
  },
  {
    date: '2023-05-03',
    name: 'I',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW'
  },
  {
    date: '2023-05-04',
    name: 'L',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW'
  },
  {
    date: '2023-05-01',
    name: 'Y',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW'
  }
])

defineComponent({
  name: 'info-view'
})
const onSubmit = () => {
  console.log('submit!')
}
</script>
<style lang="scss" scoped>
.text {
  font-size: 14px;
}
.item {
  margin-bottom: 18px;
}
.el-card {
  margin-bottom: 20px;
}
</style>
