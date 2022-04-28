import { boot } from "quasar/wrappers";
import axios from "axios";

// Be careful when using SSR for cross-request state pollution
// due to creating a Singleton instance here;
// If any client changes this (global) instance, it might be a
// good idea to move this instance creation inside of the
// "export default () => {}" function below (which runs individually
// for each client)

// vue에선 DOM을 직접 조작하지 않고 데이터 바인딩을 통해 작동하기 때문에 제이쿼리를 쓰지 않는다.
// vue는 SPA 방식이므로 다른 통신방식은 불가능, 비동기 http 통신 - ajax, axios, fetch 등을 쓰는 것이 필수다.
// axios는 json으로 자동 변환해주므로 편리하다.

const api = axios.create({ baseURL: "https://api.example.com" });

export default boot(({ app }) => {
  // for use inside Vue files (Options API) through this.$axios and this.$api

  app.config.globalProperties.$axios = axios;
  // ^ ^ ^ this will allow you to use this.$axios (for Vue Options API form)
  //       so you won't necessarily have to import axios in each vue file

  app.config.globalProperties.$api = api;
  // ^ ^ ^ this will allow you to use this.$api (for Vue Options API form)
  //       so you can easily perform requests against your app's API
});

export { axios, api }; // axios를 반환해서, component마다 직접 import {axios} 로 가져와서 쓰기. (혹은 this.$axios로 가져올 수 있음.)
