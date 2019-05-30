import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { user } from '../../Class/user'
import { LoginService } from '../../Services/login.service'
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

	@Output() isLogged = new EventEmitter<boolean>();
	
	id: number;
	loginName: String;
	password: String;
	email: String;
	userPermissionGroup: String;
	newUser: user;
	userList: user[];
	error: HttpErrorResponse;
	logged: boolean = false;
	
	loggedUser: user;

	
	  constructor(private loginService: LoginService) { }

  ngOnInit() {
	  this.loginName = '';
	  this.password = '';
	  this.email = '';
	  this.userPermissionGroup = '';
  }
	
	login(){
		if(this.loginName !== '' && this.password !== ''){
			this.loginService.login(this.loginName, this.password).
		subscribe(
			res => {
				console.log(res);
				if(res == true){
					this.loginService.getUserByUserName(this.loginName)
					.subscribe(
						res => {
								res.map(el => this.loggedUser = new user(el));
								this.logged = !this.logged;
								this.isLoggedEvent(this.logged);
							}
					);
					window.alert("Udało się poprawnie zalogować");
				}
				else{
					window.alert("Podana nazwa użytkownika i/lub hasło jest niepoprawne")
				}
			},
		);
		}
		else{
			window.alert('Brak nazwy użytkownika i/lub hasła');
		}
	}
	

	
	getAll(){
		this.loginService.getAllUsers().subscribe(res => {this.userList = res.map(el => new user(el));});
	}
	
	isLoggedEvent(log: boolean) {
		
		this.isLogged.emit(log);
		
	}
	
	
	
	



}
