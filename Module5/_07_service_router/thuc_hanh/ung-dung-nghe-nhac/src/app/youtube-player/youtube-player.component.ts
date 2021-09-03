import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {YoutubeService} from "../youtube.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-youtube-player',
  templateUrl: './youtube-player.component.html',
  styleUrls: ['./youtube-player.component.css']
})
export class YoutubePlayerComponent implements OnInit, OnDestroy {
  song: any;
  sub: Subscription | undefined;
  constructor(private youtubeService: YoutubeService,
              private activatedRouter: ActivatedRoute,
              private domSanitizer: DomSanitizer) { }
  id: number = 0;
  ngOnInit(): void {
    this.sub = this.activatedRouter.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = parseInt(<string>paramMap.get('id'));
      console.log(this.id);
      this.song = this.youtubeService.find(this.id);
      console.log(this.song)
    });
  }

  getSrc() {
    const url = 'https://www.youtube.com/embed/' + this.song.id;
    return this.domSanitizer.bypassSecurityTrustResourceUrl(url);
  }

  ngOnDestroy() {
    // @ts-ignore
    this.sub.unsubscribe();
  }

}
