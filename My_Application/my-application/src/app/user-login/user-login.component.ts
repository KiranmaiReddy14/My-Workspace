import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { LoginuserService } from '../loginuser.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  user: User = new User();
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  constructor(private userService: LoginuserService) { }

  onSubmit() {
    console.log(this.user);
    this.userService.loginUser(this.user);
  }
}
