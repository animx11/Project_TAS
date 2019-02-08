import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs/Observable';

import { AppComponent } from './app.component';
import { LoginComponent } from './Components/login/login.component';
import { LoginService } from './Services/login.service';
import { RejestracjaComponent } from './Components/rejestracja/rejestracja.component'

const ROUTES: Routes = [
	{path: 'login', component: LoginComponent},
	{path: 'rejestracja', component: RejestracjaComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RejestracjaComponent
  ],
  imports: [
    BrowserModule,
	FormsModule,
	HttpClientModule,
	RouterModule.forRoot(ROUTES)
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
