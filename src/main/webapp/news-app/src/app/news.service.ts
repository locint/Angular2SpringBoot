import { Injectable} from '@angular/core';
import {News} from "./news";
import {NewsRepository} from "./news-repository";
import {Http, URLSearchParams, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

export const NEWS: News[] = [];

@Injectable()
export class NewsService implements NewsRepository<News> {

  fetchNews(date: Date): Promise<News[]> {

    let body = new URLSearchParams();
    body.set('date', date.toString());

    this._http.post('http://localhost:8080/fetchNews', body).toPromise()
      .then(this.extractData)
      .catch(this.handleError);

    return Promise.resolve(NEWS)
  }

  createNews(news: News): void {
    this._http.post('http://localhost:8080/createNews', JSON.stringify(news)).toPromise()
      .catch(this.handleError);
  }

  updateNews(news: News): void {
    this._http.post('http://localhost:8080/updateNews', JSON.stringify(news)).toPromise()
      .catch(this.handleError);
  }

  private extractData(res: Response) {
    let body = res.json();
    return body.data || { };
  }

  private handleError (error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Promise.reject(errMsg);
  }

  constructor(private _http: Http) {}

}
