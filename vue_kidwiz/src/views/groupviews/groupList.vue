<template>
  <div class="py-5">
    <div class="container">
      <!-- row-cols-1은 행ㅇ에 열 1개씩 배치, 
        row-cols-sm-2 : 가로화면 크기가 576px보다 크거나 같으면 행에 2개씩 배치
        row-cols-md-3 : 가로화면 크기가 768px보다 크거나 같으면 행에 3개씩 배치  -->
        
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3">
        <div class="col">
          <div class="card">
            <div class="card-body">
              <img class="card-img-top" src="" alt="..." />
              <div class="card-body">
                <h5 class="card-title">Card Title</h5>
                <p class="card-text">Card Content</p>
                <a href="#" class="btn btn-primary">Link</a>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
</style>