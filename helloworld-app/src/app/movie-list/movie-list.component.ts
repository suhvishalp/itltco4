import { HttpClient } from '@angular/common/http';
import { ANALYZE_FOR_ENTRY_COMPONENTS, Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from '../model/movie.model';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  public movieList: Movie[];
  private apiUrl: string = 'http://localhost:3900/api/movies'

  constructor(private http :HttpClient) { 
    this.movieList = [];

     http.get<Movie[]>(this.apiUrl)              //construct http GET request 
        .subscribe(
          (response)=> {
            console.log('request proccessed successfully!')
            console.log(response)
            this.movieList = response;
          }, 
          (error)=> {
            console.log('something went wrong')
            console.log(error)
          }
        )
  }

  handleDelete(movie :Movie){

      this.http.delete(this.apiUrl + '/' + movie._id)
        .subscribe(
          (response)=> {
            alert('Movie is deleted')
            const index = this.movieList.findIndex(m => m._id === movie._id);
            this.movieList.splice(index, 1);
          }, 
          (error)=> {
            // alert('something went wrong')
            console.log(error)
            if(error.status === 404)
              alert(error.error)
          }
        )

  }

  ngOnInit(): void {
  }

}
