node{
  stage('SCM Checkout'){
   
    git 'https://github.com/akhilta/my-app.git'
  }
  stage('Compile-Package'){
     bat "mvn package"
     bat label: '', script: 'java -cp my-app-1.0-SNAPSHOT.jar com.mycompany.app.App'
  }
}
