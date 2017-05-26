import {Observable} from "rxjs/Observable";
import {Page} from "./page";
export interface NewsRepository<News> {

  fetchNews(date: Date):Observable<Page>;

  createNews(news: News): void;

  updateNews(news: News): void;

}
