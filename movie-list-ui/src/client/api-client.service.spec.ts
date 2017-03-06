import { MovieListApiClient } from './api-client.service'
import { Headers } from '@angular/http'

describe('ApiClient Service', () => {
  const URL = 'http://localhost:8080/api/movie'
  let headers: Headers
  let responseObservable: any
  let mapObservable: any
  let http: any
  let target: MovieListApiClient
  let movie: any
  let response: any

  beforeEach(() => {
    headers = new Headers()
    headers.append('Content-Type', 'application/json')
  })

  beforeEach(() => {
    response = jasmine.createSpyObj('response', ['json'])
    mapObservable = jasmine.createSpyObj('responseObservable', ['subscribe'])

    responseObservable = jasmine.createSpyObj('responseObservable', ['map'])
    responseObservable.map.and.callFake((callback: Function) => {
      callback(response)
      return mapObservable
    })

    http = jasmine.createSpyObj('http', ['post', 'get'])
    http.post.and.returnValue(responseObservable)
    http.get.and.returnValue(responseObservable)

    target = new MovieListApiClient(http)

    movie = {title: 'Any Movie Title'}
  })

  it('Save executes POST request with correct arguments', () => {
    target.save(movie)

    expect(http.post).toHaveBeenCalledWith(URL, movie, jasmine.objectContaining({headers: headers}))
  })

  it('Save should return the response observable', () => {
    let postReturn = target.save(movie)

    expect(postReturn).toBe(responseObservable)
  })

  it('List executes GET request with correct arguments', () => {
    target.list()

    expect(http.get).toHaveBeenCalledWith(URL)
  })

  it('List maps response to json', () => {
    target.list()

    expect(response.json).toHaveBeenCalled()
  })

  it('List should return the map observable', () => {
    let listReturn = target.list()

    expect(listReturn).toBe(mapObservable)
  })
})
