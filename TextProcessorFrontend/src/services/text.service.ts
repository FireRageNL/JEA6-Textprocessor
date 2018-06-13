import {Injectable} from '@angular/core';
import {Restangular} from 'ngx-restangular';
import {TextModel} from '../model/TextModel';

@Injectable()
export class TextService {

  constructor(private restAngular: Restangular) {
  }

  postText(text: TextModel) {
    this.restAngular.all('text').post(text);
  }
}
