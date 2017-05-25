import {Component} from '@angular/core';
import {NewsService} from "./news.service";
import {News} from "./news";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  news: News[];
  newsForm: News;
  page: String;
  subjects: Map<String, String>;
  subject: String;

  fetchNews() {
    this.newsService.fetchNews(new Date()).subscribe((news: News[]) => {
      this.news = news;
    });
    //For debug purposes
    console.log(this.news);
  }

  createNews() {
    this.newsService.createNews(this.newsForm);
    this.fetchNews();
  }

  changePage(page: String) {
    this.page = page;
    this.subject = this.subjects.get(page);
  }

  deleteNews(id: Number){
    this.newsService.deleteNews(id);
  }

  constructor(private newsService: NewsService) {
  }

  ngOnInit() {
    this.newsForm = new News();
    this.page = 'news';
    this.subjects = new Map<String, String>();
    this.subjects.set('news', "Uutiset");
    this.subjects.set('new', "Lisää");
    this.subject = this.subjects.get(this.page);
    this.fetchNews();
  }
}
