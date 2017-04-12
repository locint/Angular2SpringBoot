import { Injectable } from '@angular/core';
import {News} from "./news";
import {NewsRepository} from "./news-repository";

@Injectable()
export class NewsService implements NewsRepository<News> {

  fetchNews(key: string): Promise<News[]> {
    return null;
  }

  createNews(news: News): void {

  }

  updateNews(news: News): void {
  }


  constructor() { }

}
