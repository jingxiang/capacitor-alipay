export interface AlipayPlugin {
    echo(options: { value: string }): Promise<{ value: string }>;
    openPay(options: AlipayPayOptions): Promise<AlipayPayResult>;
    openAuth(options: AlipayAuthOptions): Promise<AlipayAuthResult>;
}

export interface AlipayPayOptions {
    payInfo: string;
}
export interface AlipayPayResult {
    resultStatus: string;
    result: string;
    memo?: string;
}
export interface AlipayAuthOptions {
    authInfo: string;
}
export interface AlipayAuthResult {
    resultStatus: string;
    result: string;
    memo?: string;
}
