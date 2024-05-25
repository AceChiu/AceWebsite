<template>
  <el-upload
    drag
    :headers="{ Authorization: token }"
    :action="props.docType ? `${fileAPI}?type=${props.docType}` : fileAPI"
    :on-success="handleSuccess"
    :on-error="handleError"
    :before-upload="beforeAvatarUpload"
  >
    <el-icon class="el-icon--upload"><UploadFilled /></el-icon>
    <div class="el-upload__text">Drop file here or <em>click to upload</em></div>
    <template #tip>
      <div class="el-upload__tip">{{ props.tip }}</div>
    </template>
  </el-upload>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { UploadFilled } from '@element-plus/icons-vue'
import { ElMessage, UploadProps } from 'element-plus'
import { base } from '~/store/base'

const baseStore = base()
const token: string = baseStore.getToken
const props = defineProps<{
  docType?: string
  tip?: string
  maxFileSize?: number
}>()

const emit = defineEmits(['onFinished'])
const fileAPI = ref(`${process.env.VITE_APP_BACKEND_URL}file/attachment/upload-single`)

function handleSuccess(res: any) {
  emit('onFinished', res)
}
function handleError(res: any) {
  ElMessage.error({
    message: res,
    duration: 5000
  })
}
const beforeAvatarUpload: UploadProps['beforeUpload'] = (rawFile) => {
  if (props.maxFileSize && rawFile.size / 1024 / 1024 > props.maxFileSize) {
    ElMessage.error(`File size can not exceed ${props.maxFileSize}MB!`)
    return false
  }
  return true
}
</script>
