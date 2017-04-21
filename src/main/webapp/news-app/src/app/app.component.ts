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
  newsForm : News;
  page: String;

  fetchNews() {
  this.newsService.fetchNews(new Date()).subscribe((news: News[]) => {
      this.news = news;
    });
  //For debug purposes
  console.log(this.news);
  }

  createNews() {
    this.newsService.createNews(this.newsForm);
  }

  changePage(wantedPage: String){
    this.page = wantedPage;
}

  constructor(private newsService: NewsService) {
  }

  ngOnInit() {
    this.newsForm = new News();
    this.page = 'news';
    this.fetchNews();
  }
}
