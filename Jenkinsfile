node{
  stage('SCM Checkout'){
   
    git 'https://github.com/akhilta/my-app.git'
  }
  stage('Compile-Package'){
     bat "mvn package"
     
  }
}
