import { Component, OnInit } from '@angular/core';

import { Observable, Subject } from 'rxjs';

import {
  debounceTime, distinctUntilChanged, switchMap
} from 'rxjs/operators';

import { Hero } from '../hero';
import { HeroService } from '../hero.service';

@Component({
  selector: 'app-hero-search',
  templateUrl: './hero-search.component.html',
  styleUrls: [ './hero-search.component.css' ]
})
export class HeroSearchComponent implements OnInit {
  heroes$: Observable<Hero[]>;
  private searchTerms = new Subject<string>();

  constructor(private heroService: HeroService) {}

  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
    this.heroes$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      //在每次击键后等待300毫秒，然后再考虑
      debounceTime(300),

      // ignore new term if same as previous term
      //如果与前一个词相同，则忽略新词
      distinctUntilChanged(),

      // switch to new search observable each time the term changes
      //每次字词更改时切换到新的可观察的搜索
      switchMap((term: string) => this.heroService.searchHeroes(term)),
    );
  }
}
