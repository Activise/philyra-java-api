package io.activise.philyra.paging.mongodb;

import java.util.List;

import io.activise.philyra.paging.PagedList;
import io.quarkus.mongodb.panache.PanacheQuery;

public class MongoPanachePagedList<T> implements PagedList<T> {
  private static final int DEFAULT_PAGE_COUNT = 50;

  private PanacheQuery<? extends T> query;
  private int currentPage;
  private int countPerPage;
  private List<? extends T> list;

  private MongoPanachePagedList(PanacheQuery<? extends T> query, int currentPage, int countPerPage,
      List<? extends T> list) {
    this.query = query;
    this.currentPage = currentPage;
    this.countPerPage = countPerPage;
    this.list = list;
  }

  public static <T> MongoPanachePagedList<T> of(PanacheQuery<? extends T> query) {
    return of(query, DEFAULT_PAGE_COUNT);
  }

  public static <T> MongoPanachePagedList<T> of(PanacheQuery<? extends T> query, int countPerPage) {
    query = query.page(0, countPerPage);
    return new MongoPanachePagedList<>(query, 1, countPerPage, query.list());
  }

  public static <T> MongoPanachePagedList<T> of(PanacheQuery<? extends T> query, MongoPanachePagedList<T> base) {
    return new MongoPanachePagedList<>(query, base.getCountPerPage(), base.getCountPerPage(), query.list());
  }

  @Override
  public PagedList<T> getPage(int page, int count) {
    this.currentPage = page;
    setCountPerPage(countPerPage);
    return of(query.page(page - 1, count), this);
  }

  @Override
  public PagedList<T> getPage(int page) {
    this.currentPage = page;
    return of(query.page(page - 1, countPerPage), this);
  }

  @Override
  public PagedList<T> nextPage() {
    this.currentPage += 1;
    return of(query.nextPage(), this);
  }

  @Override
  public PagedList<T> previousPage() {
    this.currentPage -= 1;
    return of(query.previousPage(), this);
  }

  @Override
  public void setCountPerPage(int countPerPage) {
    this.countPerPage = countPerPage;
  }

  @Override
  public int getCountPerPage() {
    return this.countPerPage;
  }

  @Override
  public int getCurrentPage() {
    return currentPage;
  }

  @Override
  public long count() {
    return query.count();
  }

  @Override
  public int pageCount() {
    return query.pageCount();
  }

  @Override
  public List<? extends T> asJavaList() {
    return list;
  }

}
