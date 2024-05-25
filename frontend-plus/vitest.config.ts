import vue from '@vitejs/plugin-vue'
import path from 'path'
const pathSrc = path.resolve(__dirname, './src')

export default {
  plugins: [vue()],
  resolve: {
    alias: {
      '~/': `${pathSrc}/`
    }
  },
  test: {
    deps: {
      inline: ['element-plus']
    },
    testTimeout: 1000000,
    environment: 'happy-dom'
  }
}
