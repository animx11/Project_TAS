import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { user } from '../Class/user'
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';

import 'rxjs/add/operator/catch';


const apiUrl: String = 'http://localhost:8080/api';

@Injectable()
export class LoginService {


  constructor(private http: HttpClient) {}
	
	login(userName: String, password: String): Observable<any> {
		return this.http.get(`${apiUrl}/loginUser?userName=${userName}&userPassword=${password}`);
	}

	createNew(obj: user): Observable<any>{
		return this.http.post(`${apiUrl}/users`, obj);
	}

	getAllUsers(): Observable<any> {
		return this.http.get(`${apiUrl}/users`);
	}
	
	getUserByUserName(userName: String): Observable<any>{
		return this.http.get(`${apiUrl}/users_by_userName?userName=${userName}`);
	}

}
