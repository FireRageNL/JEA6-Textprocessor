import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import {RestangularModule} from 'ngx-restangular';
import {TextService} from '../services/text.service';

export function RestangularConfigFactory(RestangularProvider) {
  RestangularProvider.setBaseUrl('http://localhost:8080/');
}


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RestangularModule.forRoot(RestangularConfigFactory)
  ],
  providers: [TextService],
  bootstrap: [AppComponent]
})
export class AppModule { }
