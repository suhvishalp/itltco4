import { Genre } from './genre.model';


export class Movie {

    constructor(
        public _id:string, 
        public title:string,
        public numberInStock:string, 
        public dailyRentalRate:string, 
        public genre:Genre
    ){}
}