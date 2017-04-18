export interface NewsRepository<News> {

  fetchNews(date: Date):Promise<News[]>;

  createNews(news: News): void;

  updateNews(news: News): void;

}
