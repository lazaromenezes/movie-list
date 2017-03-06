import { Component, OnInit } from '@angular/core'
import { MovieListApiClient } from '../client/api-client.service'

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html'
})

export class AppComponent implements OnInit {
  movies: Array<any>
  title: string

  constructor(private client: MovieListApiClient) {
    this.title = ''
  }

  save() {
    let movie = {
      title: this.title
    }

    this.client.save(movie).subscribe(result => {
      this.loadMovies()
      this.title = ''
    })
  }

  ngOnInit() {
    this.loadMovies()
  }

  private loadMovies() {
    this.client.list().subscribe(results => this.movies = results)
  }
}
