import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User = new User();
 
  constructor(private httpClientService: HttpClientService) { }

  ngOnInit(): void {
  }

  Add(): void {
    this.httpClientService.addUser(this.user).subscribe(data => {
      if(data) {
      alert("User added successfully.");
      console.log(this.user);
      }},
      error => {
        alert("Cannot add user");
      }
      );
  }

}
