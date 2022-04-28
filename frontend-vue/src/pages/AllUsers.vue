<script setup>
import UserList from "components/UserList.vue";
import { ref, onMounted } from "vue";
import { axios } from "boot/axios.js"; //.js 생략?

const list = ref([]);

function fetchData(/*pageNum*/) {
  axios
    .get("/api/user") //?page=" + pageNum,   경로에 /붙이기
    .then((res) => {
      //undefined 이유 : ref 타입인데 this.로 접근하고, .value도 사용하지 않았다

      //오류 처리 할 것
      //resultCode는 템플릿에서 쓰이면 안 되고 여기서 체크해야 함.
      //null은 undeifined가 됨 ===undefined
      if (res.data.resultCode != 0) {
        //이쪽은 db에러.
        // exceoption에 따른 if문 처리->  메시지 dialog로 에러를 보여주기 (notify??)
        // 메시지 박스 UI처리.
      }
      list.value = res.data.userList;
    })
    .catch((err) => {
      //네트워크 환경적인, 크리티컬한 에러.
      // console.error(err); //console.log 대신. test할 땐 console도 좋음.
      //ALERT 권장 (사용자들이 봐도 모르는 에러. 개발자가 보기 좋게 쓰기)
      alert(`통신 중 에러발생. [${err}]`); //시스템 에러. 이런 에러는 alert가 더 좋음.
    });

  // 비동기 방식 : 함수형 프로그래밍
  // axios의 then, catch 등 -> 함수를 넘김
}

onMounted(() => {
  fetchData();
});
</script>

<template>
  <div id="all_users">
    <UserList :userList="list"></UserList>
  </div>
</template>
