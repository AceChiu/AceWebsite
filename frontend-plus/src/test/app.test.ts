import { expect, test } from 'vitest'
/// write App.vue test here
test('App.vue', async () => {
  expect(true).toBe(true)
  const cmp = await import('../App.vue')
  expect(cmp).toBeDefined()
})
