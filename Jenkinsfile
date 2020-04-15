node{
  stage('SCM Checkout'){
   
    git 'https://github.com/akhilta/sapient_work_1.git'
  }
  stage('Compile-Package'){
     bat "mvn package"
     
  }
}
