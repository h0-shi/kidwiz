import axios from 'axios';

const callApi = async () => {
  try {
    const response = await axios.get('www.career.go.kr/inspct/openapi/test/questions?apikey=4c62bb597366006e31a46f7ec7737e85&q=심리검사변수', { // API_ENDPOINT를 실제 호출하고자 하는 API의 주소로 변경하세요.
      headers: {
        'Authorization': `Bearer 4c62bb597366006e31a46f7ec7737e85` // 필요한 경우 인증 키를 추가하세요.
      }
    });
    console.log(response.data);
  } catch (error) {
    console.error(error);
  }
}
// callApi 함수 호출
callApi();