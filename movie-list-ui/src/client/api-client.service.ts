import { Injectable } from '@angular/core'
import { Http, Headers, RequestOptions } from '@angular/http'
import 'rxjs/add/operator/map'

@Injectable()
export class MovieListApiClient {
  private URL = process.env.API_URL || 'http://localhost:8080/api/movie'

  constructor(private http: Http) {
  }

  list() {
    return this.http.get(this.URL).map(response => response.json())
  }

  save(movie: any) {
    let headers = new Headers()
    headers.append('Content-Type', 'application/json')
    let options = new RequestOptions()
    options.headers = headers

    return this.http.post(this.URL, movie, options)
  }
}
