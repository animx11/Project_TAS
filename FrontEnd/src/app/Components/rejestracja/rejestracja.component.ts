import { Component, OnInit } from '@angular/core';
import { user } from '../../Class/user'
import { LoginService } from '../../Services/login.service'
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';



@Component({
  selector: 'app-rejestracja',
  templateUrl: './rejestracja.component.html',
  styleUrls: ['./rejestracja.component.css']
})
export class RejestracjaComponent implements OnInit {

	id: number;
	loginName: String;
	password: String;
	email: String;
	userPermissionGroup: String;
	newUser: user;
	userList: user[];
	error: HttpErrorResponse;
	
	constructor(private loginService: LoginService) { }

  ngOnInit() {
	  this.loginName = '';
	  this.password = '';
	  this.email = '';
	  this.userPermissionGroup = '';
	  this.newUser = new user();
  }

	rejestracja(){
		
		this.newUser.setUserName(this.loginName);
		this.newUser.setPassword(this.password);
		this.newUser.setEmail(this.email);
		this.newUser.setUserPermissionGroup("User")
		if(this.loginName != "" && this.password != "" && this.email != ""){
			this.loginService.createNew(this.newUser).subscribe(
				res => {
					console.log(res);
					window.alert("Udało się poprawnie utworzyć użytkownika");
				},
				error => {
					if(error.status == "500"){
						window.alert("Podana nazwa użytkownika jest już zajęta");
					}
					else if(error.status == "400"){
						window.alert("Podany adres e-mail jest nieprawidłowy");
					}
					else if(error.status == "409"){
						window.alert("Podany adres e-mail jest zajęty");
					}
					else{
						window.alert("Nie można połączyć się z serwerem");
					}
				}
			);
		}
		else{
			window.alert("Żadne z pól nie może być pustę");
		}
	}
	
	


}
