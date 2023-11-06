# @liyanjie2048/capacitor-alipay

Alipay plugin for Capacitor

## Install

```bash
npm install @liyanjie2048/capacitor-alipay
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`openPay(...)`](#openpay)
* [`openAuth(...)`](#openauth)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### openPay(...)

```typescript
openPay(options: AlipayPayOptions) => Promise<AlipayPayResult>
```

| Param         | Type                                                          |
| ------------- | ------------------------------------------------------------- |
| **`options`** | <code><a href="#alipaypayoptions">AlipayPayOptions</a></code> |

**Returns:** <code>Promise&lt;<a href="#alipaypayresult">AlipayPayResult</a>&gt;</code>

--------------------


### openAuth(...)

```typescript
openAuth(options: AlipayAuthOptions) => Promise<AlipayAuthResult>
```

| Param         | Type                                                            |
| ------------- | --------------------------------------------------------------- |
| **`options`** | <code><a href="#alipayauthoptions">AlipayAuthOptions</a></code> |

**Returns:** <code>Promise&lt;<a href="#alipayauthresult">AlipayAuthResult</a>&gt;</code>

--------------------


### Interfaces


#### AlipayPayResult

| Prop               | Type                |
| ------------------ | ------------------- |
| **`resultStatus`** | <code>string</code> |
| **`result`**       | <code>string</code> |
| **`memo`**         | <code>string</code> |


#### AlipayPayOptions

| Prop          | Type                |
| ------------- | ------------------- |
| **`payInfo`** | <code>string</code> |


#### AlipayAuthResult

| Prop               | Type                |
| ------------------ | ------------------- |
| **`resultStatus`** | <code>string</code> |
| **`result`**       | <code>string</code> |
| **`memo`**         | <code>string</code> |


#### AlipayAuthOptions

| Prop           | Type                |
| -------------- | ------------------- |
| **`authInfo`** | <code>string</code> |

</docgen-api>
