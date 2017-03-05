import { NgModule } from '@angular/core'
import { BrowserModule }  from '@angular/platform-browser'
import { AppComponent } from './app.component'
import { MovieListApiClientModule } from '../client/client.module'

@NgModule({
  imports: [
    BrowserModule,
    MovieListApiClientModule
  ],
  declarations: [
    AppComponent
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
