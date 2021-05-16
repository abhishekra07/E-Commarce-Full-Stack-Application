import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  @ViewChild('searchInput') searchInput;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  callSearchService(keyword: string): void {
    console.log(`searched word is ${keyword}`);
    this.router.navigateByUrl(`/search/${keyword}`);
    this.searchInput.nativeElement.value = '';
  }
}
