import { WebPlugin } from '@capacitor/core';

import type {
    AlipayAuthOptions,
    AlipayAuthResult,
    AlipayPayOptions,
    AlipayPayResult,
    AlipayPlugin,
} from './definitions';

export class AlipayWeb extends WebPlugin implements AlipayPlugin {
    async echo(options: { value: string }): Promise<{ value: string }> {
        console.log('ECHO', options);
        return options;
    }
    async openPay(options: AlipayPayOptions): Promise<AlipayPayResult> {
        console.log(options);
        console.log('Alipay plugin for Capacitor: not supported on web.');
        return { resultStatus: '0', result: '' };
    }

    async openAuth(options: AlipayAuthOptions): Promise<AlipayAuthResult> {
        console.log(options);
        console.log('Alipay plugin for Capacitor: not supported on web.');
        return { resultStatus: '0', result: '' };
    }
}
