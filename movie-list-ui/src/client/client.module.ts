import { NgModule } from '@angular/core'
import { HttpModule } from '@angular/http'
import { MovieListApiClient } from './api-client.service'

@NgModule({
  imports: [ HttpModule ],
  providers: [ MovieListApiClient ]
})
export class MovieListApiClientModule { }

