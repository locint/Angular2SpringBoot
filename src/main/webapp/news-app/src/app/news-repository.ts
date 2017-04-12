import {News} from "./news";

export interface NewsRepository<T> {

  fetchNews(date: String):Promise<News[]>;

  createNews(news: News): void;

  updateNews(news: News): void;

}
