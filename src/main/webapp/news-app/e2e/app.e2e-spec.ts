import { NewsAppPage } from './app.po';

describe('news-app App', function() {
  let page: NewsAppPage;

  beforeEach(() => {
    page = new NewsAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
