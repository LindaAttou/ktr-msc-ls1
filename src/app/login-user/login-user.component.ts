import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

    user:User= new User();
  constructor(private loginService:LoginService) { }

  ngOnInit(): void {
  }
    userLogin(){
      console.log(this.user);
      this.loginService.loginUser(this.user).subscribe(data=>{
        alert("login successfully");
      },
      error=>alert("sorry, please enter correct Email and password"))
    }

  

}
