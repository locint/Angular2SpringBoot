import { Component } from '@angular/core';
import {NewsService} from "./news.service";
import {News} from "./news";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  news: News[];

  fetchNews() {
  this.newsService.fetchNews(new Date()).subscribe((news: News[]) => {
      this.news = news;
    });
  //For debug purposes
  console.log(this.news);
  }

  constructor(private newsService: NewsService) {
  }
}
