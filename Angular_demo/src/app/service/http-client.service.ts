import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../user';


@Injectable({
  providedIn: 'root'
})
export class HttpClientService {
  
  constructor(private http : HttpClient) {
   }

   public addUser(user) {
     return this.http.post<User>("http://localhost:8765/user", user);
   }
}
