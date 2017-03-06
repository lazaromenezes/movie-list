import { TestBed } from '@angular/core/testing'
import { AppComponent } from './app.component'

describe('App Component', () => {
  let target: AppComponent
  let apiClient: any
  let listObservable: any
  let saveObservable: any
  let movieList: Array<any>

  beforeEach(() => {
    movieList = [
      {title: 'Movie A'},
      {title: 'Movie B'}
    ]
    listObservable = jasmine.createSpyObj('observable', ['subscribe'])
    listObservable.subscribe.and.callFake((callback: Function) => callback(movieList))

    saveObservable = jasmine.createSpyObj('observable', ['subscribe'])
    saveObservable.subscribe.and.callFake((callback: Function) => callback(null))

    apiClient = jasmine.createSpyObj('client', ['save', 'list'])
    apiClient.list.and.returnValue(listObservable)
    apiClient.save.and.returnValue(saveObservable)

    target = new AppComponent(apiClient)
  })

  it('title should be empty on initialize', () => {
    expect(target.title).toBe('')
  })

  it ('should load movies on init', () => {
    target.ngOnInit()
    expect(apiClient.list).toHaveBeenCalled()
    expect(target.movies).toBe(movieList)
  })

  it ('save method should call client with movie object', () => {
    target.title = 'Movie Title'
    target.save()

    expect(apiClient.save).toHaveBeenCalledWith({title: 'Movie Title'})
  })

  it ('should load movies after saving', () => {
    target.title = 'Movie Title'
    target.save()

    expect(apiClient.list).toHaveBeenCalled()
    expect(target.movies).toBe(movieList)
  })

  it ('title must be empty after saving', () => {
    target.title = 'Movie Title'
    target.save()

    expect(target.title).toBe('')
  })
})
