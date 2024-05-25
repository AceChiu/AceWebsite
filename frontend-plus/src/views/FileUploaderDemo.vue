<template>
  <PageHeader title="File Uploader Demo" />
  <el-card>
    <DragToUpload :maxFileSize="5" tip="files with a size less than 5MB"></DragToUpload>
  </el-card>
</template>
