<template>
  <div v-loading="baseStore.loading">
    <PageHeader :title="$t('TABLE_DEMO')" />
    <el-card>
      <ListTable :isLoading="false" :tableCol="tableCol" :tableData="tableData" :stripe="false">
        <template #templateEX="{ scope: { row } }">
          <span v-html="row.templateEX || '--'" />
        </template>
      </ListTable>
    </el-card>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { base } from '~/store/base'

const baseStore = base()

const tableCol = ref([
  { colKey: 'date', name: '日期', sortable: true },
  {
    colKey: 'name',
    name: '姓名',
    externalLink: (_col: any, row: { externalLink: string }) => row.externalLink
  },
  { colKey: 'address', name: '地址' },
  { colKey: 'switcher', name: 'Switcher', type: 'switch' },
  { colKey: 'templateEX', name: 'TemplateEX' }
])
const tableData = ref([
  {
    date: '2023-05-01',
    name: 'E',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW',
    templateEX: '<h2>from template</h2><h3>U can add whatever U want</h3>'
  },
  {
    date: '2023-05-02',
    name: 'M',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW',
    templateEX: '<h1>from template</h1>'
  },
  {
    date: '2023-05-03',
    name: 'I',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW',
    templateEX: '<h1>from template</h1>'
  },
  {
    date: '2023-05-04',
    name: 'L',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW',
    templateEX: '<h1>from template</h1>'
  },
  {
    date: 'Today',
    name: 'Y',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW'
  },
  {
    date: '2023-05-01',
    name: 'E',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW',
    templateEX: '<h2>from template</h2><h3>U can add whatever U want</h3>'
  },
  {
    date: '2023-05-02',
    name: 'M',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW',
    templateEX: '<h1>from template</h1>'
  },
  {
    date: '2023-05-03',
    name: 'I',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW',
    templateEX: '<h1>from template</h1>'
  },
  {
    date: '2023-05-04',
    name: 'L',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW',
    templateEX: '<h1>from template</h1>'
  },
  {
    date: 'Today',
    name: 'Y',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW'
  },
  {
    date: '2023-05-01',
    name: 'E',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW',
    templateEX: '<h2>from template</h2><h3>U can add whatever U want</h3>'
  },
  {
    date: '2023-05-02',
    name: 'M',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW',
    templateEX: '<h1>from template</h1>'
  },
  {
    date: '2023-05-03',
    name: 'I',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW',
    templateEX: '<h1>from template</h1>'
  },
  {
    date: '2023-05-04',
    name: 'L',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW',
    templateEX: '<h1>from template</h1>'
  },
  {
    date: 'Today',
    name: 'Y',
    address: 'No. 189, Grove St, Los Angeles',
    externalLink: 'https://www.google.com.tw/?hl=zh_TW'
  }
])
</script>
