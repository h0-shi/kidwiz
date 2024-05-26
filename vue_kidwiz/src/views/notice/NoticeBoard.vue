<template>
  <div>
    <h1>게시판</h1>
    <button v-if="isAdmin" @click="toggleForm">글 쓰기</button>
    <div v-if="showForm">
      <input v-model="newPostTitle" placeholder="제목">
      <textarea v-model="newPostContent" placeholder="내용"></textarea>
      <button class="btn btn-success" style="background-color: #67BF4E;" @click="addPost">글 등록</button>
    </div>
    <div v-for="(post, index) in posts" :key="index">
      <div @click="toggleContent(index)">
        <p>{{ post.ntitle }}</p>
      </div>
      <div v-if="expandedIndex === index">
        <p>{{ post.ncontent }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      showForm: false,
      newPostTitle: '',
      newPostContent: '',
      posts: [],
      dept: null,
      isAdmin: true,
      expandedIndex: null
    };
  },
  mounted() {
    axios.post("http://localhost:8080/api/getMemberType", { withCredentials: true }).then((res) => {
      console.log("noticeboard mounted", res.data);
      this.dept = res.data.dept;
      this.isAdmin = this.dept === '관리자';
    }).catch(() => {
      this.dept = null;
      this.isAdmin = false; // 사용자 권한 정보를 가져오지 못한 경우 isAdmin 값을 false로 설정
    });
    this.fetchPosts();
  },
  methods: {
    toggleForm() {
      this.showForm = !this.showForm;
    },
    addPost() {
      if (this.newPostTitle.trim() !== '' && this.newPostContent.trim() !== '') {
        console.log("noticeboard addPost", this.newPostTitle, this.newPostContent);
        axios.post("http://localhost:8080/api/notice/posts", {
          ntitle: this.newPostTitle,
          ncontent: this.newPostContent
        }).then(() => {
          this.fetchPosts();
          this.newPostTitle = '';
          this.newPostContent = '';
          this.showForm = false;
        }).catch((error) => {
          console.error('Error adding notice:', error);
        });
      }
    },
    fetchPosts() {
      axios.get("http://localhost:8080/api/notice/posts").then((res) => {
        console.log("noticeboard fetchPosts", res.data);
        this.posts = res.data;
      }).catch((error) => {
        console.error('Error fetching notices:', error);
      });
    },
    toggleContent(index) {
      this.expandedIndex = this.expandedIndex === index ? null : index;
    }
  }
};
</script>
  
  <style scoped>
  /* 스타일 추가 */
  </style>
  