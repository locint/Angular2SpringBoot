import { Injectable} from '@angular/core';
import {News} from "./news";
import {NewsRepository} from "./news-repository";
import {Http, Headers, URLSearchParams, Response, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {DatePipe} from "@angular/common";
import {Observable} from "rxjs/Observable";

@Injectable()
export class NewsService implements NewsRepository<News> {

  fetchNews(date: Date): Observable<News[]> {
    let body = new URLSearchParams();
    let datePipe = new DatePipe("en-US");
    body.set('date', datePipe.transform(date, 'dd.MM.yyyy').toString());
    return this._http.post('http://localhost:8080/fetchNews', body).map((response: Response) => {
      return <News[]>response.json();
    });
  }

  createNews(news: News): void {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    this._http.post('http://localhost:8080/createNews', JSON.stringify(news), options).subscribe((response) => {

    });
  }

  updateNews(news: News): void {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    this._http.post('http://localhost:8080/updateNews', JSON.stringify(news), options).subscribe((response) => {

    });
  }

  deleteNews(id: Number): void{
    console.log(id);
    let body = new URLSearchParams();
    body.set('id', id.toString());
    this._http.delete('http://localhost:8080/deleteNews', new RequestOptions({
      body: body
    })).map((response: Response) => {
      console.log(response);
    });

  }

  constructor(private _http: Http) {}

}
