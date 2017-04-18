import {Observable} from "rxjs/Observable";
export interface NewsRepository<News> {

  fetchNews(date: Date):Observable<News[]>;

  createNews(news: News): void;

  updateNews(news: News): void;

}
