import { Injectable } from '@angular/core'
import { Http, Headers, RequestOptions } from '@angular/http'
import 'rxjs/add/operator/map'

@Injectable()
export class MovieListApiClient {
  constructor(private http: Http) {
  }

  list() {
    const url = 'http://localhost:8080/movie-list-api/api/movie'

    return this.http.get(url).map(response => response.json())
  }

  save(movie: any) {
    const url = 'http://localhost:8080/movie-list-api/api/movie'

    let headers = new Headers()
    headers.append('Content-Type', 'application/json')
    let options = new RequestOptions()
    options.headers = headers

    return this.http.post(url, movie, options)
  }
}
