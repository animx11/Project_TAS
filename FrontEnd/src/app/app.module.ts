import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs/Observable';

import { AppComponent } from './app.component';
import { LoginComponent } from './Components/login/login.component';
import { LoginService } from './Services/login.service';
import { BandService } from './Services/band.service';
import { RejestracjaComponent } from './Components/rejestracja/rejestracja.component';
import { AddBandComponent } from './Components/bands/add-band/add-band.component'

const ROUTES: Routes = [
	{path: 'login', component: LoginComponent},
	{path: 'rejestracja', component: RejestracjaComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RejestracjaComponent,
    AddBandComponent
  ],
  imports: [
    BrowserModule,
	FormsModule,
	HttpClientModule,
	RouterModule.forRoot(ROUTES)
  ],
  providers: [LoginService, BandService],
  bootstrap: [AppComponent]
})
export class AppModule { }
