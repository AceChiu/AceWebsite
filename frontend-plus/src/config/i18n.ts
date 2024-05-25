import { createI18n } from 'vue-i18n'
import tw from './language/tw.json'
import en from './language/en.json'
import cn from './language/cn.json'

const i18n = createI18n({
  legacy: false,
  locale: 'tw',
  fallbackLocale: 'tw',
  messages: {
    tw: tw,
    en: en,
    cn: cn
  }
})

export default i18n
